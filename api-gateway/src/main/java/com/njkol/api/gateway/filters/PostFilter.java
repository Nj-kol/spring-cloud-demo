package com.njkol.api.gateway.filters;

import org.apache.log4j.Logger;

import com.netflix.zuul.ZuulFilter;

public class PostFilter extends ZuulFilter {

	private final static Logger logger = Logger.getLogger(ZuulFilter.class);

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		logger.info("Using Post Filter");
		return null;
	}
}
