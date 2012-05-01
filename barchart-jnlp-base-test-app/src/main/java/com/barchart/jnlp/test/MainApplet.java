package com.barchart.jnlp.test;

import java.applet.Applet;
import java.awt.Graphics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

}
