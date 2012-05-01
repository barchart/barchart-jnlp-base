package com.barchart.jnlp.test;

import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.pivot.wtk.DesktopApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.barchart.platform.host.main.App;

/**
 * app host runner;
 */
public class HostWrap {

	private static final Logger log = LoggerFactory.getLogger(HostWrap.class);

	/** load from class path */
	private static Properties load(final String fileURL) throws Exception {

		final InputStream stream = HostWrap.class.getClassLoader()
				.getResourceAsStream(fileURL);

		final Properties props = new Properties();

		props.load(stream);

		stream.close();

		return props;

	}

	public static void run() throws Exception {

		/** system properties */
		{

			final Properties props = load("runner/system.properties");

			for (final Entry<Object, Object> entry : props.entrySet()) {
				final String key = entry.getKey().toString();
				final String value = entry.getValue().toString();
				log.debug("system property : {}={}", key, value);
				System.setProperty(key, value);
			}

		}

		/** platform properties */
		{

			final Properties props = load("runner/platform.properties");

			final int size = props.size();

			final String[] appArgs = new String[size];

			int index = 0;
			for (final Entry<Object, Object> entry : props.entrySet()) {
				final String key = entry.getKey().toString();
				final String value = entry.getValue().toString();
				final String arg = "--" + key + "=" + value;
				log.debug("platform property : {}={}", key, value);
				appArgs[index] = arg;
				index++;
			}

			DesktopApplicationContext.main(App.class, appArgs);

		}

	}

}
