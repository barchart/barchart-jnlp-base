/**
 * Copyright (C) 2011-2012 Barchart, Inc. <http://www.barchart.com/>
 *
 * All rights reserved. Licensed under the OSI BSD License.
 *
 * http://www.opensource.org/licenses/bsd-license.php
 */
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
 * 
 * note: if you intend to run as "main()", execute maven-package-xxx.ant first
 * to produce valid resource files
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

	public static void main(final String[] args) throws Exception {

		/** startup properties */
		final String folder;
		{
			final Properties props = load("barchart.properties");
			folder = props.getProperty("folder");
			log.debug("config folder : {}", folder);
		}

		/** system properties */
		{

			final Properties props = load(folder + "/" + "system.properties");

			for (final Entry<Object, Object> entry : props.entrySet()) {
				final String key = entry.getKey().toString();
				final String value = entry.getValue().toString();
				log.debug("system property : {}={}", key, value);
				System.setProperty(key, value);
			}

		}

		/** platform properties */
		{

			final Properties props = load(folder + "/" + "platform.properties");

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
