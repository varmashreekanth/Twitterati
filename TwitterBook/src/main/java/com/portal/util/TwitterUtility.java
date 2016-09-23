package com.portal.util;

import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

public class TwitterUtility {
	
	public static Twitter getTwitterTemplate(String accountName){
		String consumerKey = "X0e5A6PQE09N0lkdJluZWTn7V";
		String consumerSecret = "J5eKvB37YDa3tMyRVDKDInfiCgJ6cJtPJnyFI8uIbp800CxI3M";
		//String accessToken = "";
		//String accessTokenSecret = "";
		
		//Preconditions.checkNotNull(consumerKey);
		//Preconditions.checkNotNull(consumerSecret);
		//Preconditions.checkNotNull(accessToken);
		//Preconditions.checkNotNull(accessTokenSecret);
		
		TwitterTemplate twitterTemplate = new TwitterTemplate(consumerKey, consumerSecret);
		return twitterTemplate;
		
	}
}
