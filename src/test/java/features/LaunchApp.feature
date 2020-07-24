Feature: I want to launch different apps
In order to demo this framework

@TestFeature
Scenario: This is a sample scenario to launch gmail
Given Launch "gmail" app
Then Wait for some a few seconds "10000"
And Close the app

@TestFeature
Scenario: This is a sample scenario to launch paytm
Given Launch "playstore" app
Then Wait for some a few seconds "10000"
And Close the app