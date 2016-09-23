/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.portal.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.kernel.util.StringPool;
import com.portal.helper.TwitterViewHelper;

@Controller
@RequestMapping("VIEW")
public class TwitterViewController {
	
	@Autowired
	private TwitterViewHelper twitterViewHelper;
	
	
	
	public TwitterViewHelper getTwitterViewHelper() {
		return twitterViewHelper;
	}

	public void setTwitterViewHelper(TwitterViewHelper twitterViewHelper) {
		this.twitterViewHelper = twitterViewHelper;
	}

	@RenderMapping
	public String showView(Model model) {
		model.addAttribute("releaseInfo", ReleaseInfo.getReleaseInfo());

		return "TwitterBook/view";
	}
	
	@ActionMapping(params="action=fetchTweetsByUser")
	public void fetchTweetsByUser(ActionRequest actionRequest,ActionResponse actionResponse){
		String userName = ParamUtil.getString(actionRequest, "user", StringPool.BLANK);
		twitterViewHelper.fetchTweets(userName);
	}
	
	

}