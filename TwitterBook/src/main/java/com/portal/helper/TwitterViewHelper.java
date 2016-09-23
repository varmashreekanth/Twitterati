package com.portal.helper;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.springframework.social.twitter.api.Tweet;

public interface TwitterViewHelper {
	public List<Tweet> fetchTweets(String userName);
}
