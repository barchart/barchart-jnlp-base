/**
 * Copyright (C) 2011-2012 Barchart, Inc. <http://www.barchart.com/>
 *
 * All rights reserved. Licensed under the OSI BSD License.
 *
 * http://www.opensource.org/licenses/bsd-license.php
 */
package com.barchart.jnlp.test;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** test application; must provide main() */
@SuppressWarnings("serial")
public class MainApplication extends Frame {

	private static final Logger log = LoggerFactory
			.getLogger(MainApplication.class);

	public static void main(final String[] args) throws Exception {

		log.info("init");

		final Frame frame = new MainApplication();

		frame.setSize(200, 100);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent we) {
				log.info("exit");
				System.exit(0);
			}
		});

		frame.setVisible(true);

		log.info("done");

		// ################################

		HostWrap.main(null);

		// ################################

	}

	@Override
	public void paint(final Graphics g) {

		log.info("paint");

		g.drawString("application", 50, 50);

		g.drawArc(30, 30, 20, 20, 0, 360);

	}

}
