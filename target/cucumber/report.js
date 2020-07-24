$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("LaunchApp.feature");
formatter.feature({
  "line": 1,
  "name": "I want to launch different apps",
  "description": "In order to demo this framework",
  "id": "i-want-to-launch-different-apps",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5138879400,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "This is a sample scenario to launch gmail",
  "description": "",
  "id": "i-want-to-launch-different-apps;this-is-a-sample-scenario-to-launch-gmail",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@TestFeature"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Launch \"gmail\" app",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Wait for some a few seconds \"10000\"",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Close the app",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "gmail",
      "offset": 8
    }
  ],
  "location": "LaunchApp.launch_something_app(String)"
});
formatter.result({
  "duration": 22247071200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10000",
      "offset": 29
    }
  ],
  "location": "LaunchApp.wait_for_some_a_few_seconds_something(String)"
});
formatter.result({
  "duration": 10000679700,
  "status": "passed"
});
formatter.match({
  "location": "LaunchApp.close_the_app()"
});
formatter.result({
  "duration": 1743772600,
  "status": "passed"
});
formatter.after({
  "duration": 8091337700,
  "status": "passed"
});
formatter.before({
  "duration": 5066902300,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "This is a sample scenario to launch paytm",
  "description": "",
  "id": "i-want-to-launch-different-apps;this-is-a-sample-scenario-to-launch-paytm",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@TestFeature"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "Launch \"playstore\" app",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "Wait for some a few seconds \"10000\"",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "Close the app",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "playstore",
      "offset": 8
    }
  ],
  "location": "LaunchApp.launch_something_app(String)"
});
formatter.result({
  "duration": 18774912100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10000",
      "offset": 29
    }
  ],
  "location": "LaunchApp.wait_for_some_a_few_seconds_something(String)"
});
formatter.result({
  "duration": 9999603500,
  "status": "passed"
});
formatter.match({
  "location": "LaunchApp.close_the_app()"
});
formatter.result({
  "duration": 1743266200,
  "status": "passed"
});
formatter.after({
  "duration": 8083280300,
  "status": "passed"
});
});