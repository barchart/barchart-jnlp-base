/**
 * Copyright (C) 2011-2012 Barchart, Inc. <http://www.barchart.com/>
 *
 * All rights reserved. Licensed under the OSI BSD License.
 *
 * http://www.opensource.org/licenses/bsd-license.php
 */
package com.barchart.jnlp.test;

import java.applet.Applet;
import java.awt.Graphics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** test applet; must extend java.applet.Applet */
@SuppressWarnings("serial")
public class MainApplet extends Applet {

	private static final Logger log = LoggerFactory.getLogger(MainApplet.class);

	@Override
	public void init() {

		log.info("init");

	}

	@Override
	public void stop() {

		log.info("done");

	}

	@Override
	public void paint(final Graphics g) {

		log.info("paint");

		g.drawString("applet", 50, 50);

		g.drawArc(30, 30, 20, 20, 0, 360);

	}

	public static void main(final String[] args) {
		// TODO
	}

}
