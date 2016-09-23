package com.portal.helper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.social.twitter.api.TimelineOperations;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Component;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.portal.helper.TwitterViewHelper;
import com.portal.util.TwitterUtility;

@Component
@Qualifier("twitterViewHelper")
public class TwitterViewHelperImpl implements TwitterViewHelper{

	@Override
	public List<Tweet> fetchTweets(String userName) {
		List<Tweet> tweetList = new ArrayList<Tweet>();
		
		Twitter twitter=TwitterUtility.getTwitterTemplate(userName);
		tweetList=queryForTweets(userName, twitter);
		return tweetList;
	}
	
	private List<Tweet> queryForTweets(String screenName,Twitter twitter) {

	    TimelineOperations timelineOps = twitter.timelineOperations();
	    List<Tweet> results = timelineOps.getUserTimeline(screenName);
	    System.out.println("Fond Twitter timeline for :" + screenName + " adding " + results.size() + " tweets to model");
	    return results;
	  }

}
