$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/TestFile.feature");
formatter.feature({
  "name": "Testing",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Testing the URL open",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@testing"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open the daraz URL",
  "keyword": "Given "
});
formatter.match({
  "location": "TestingSteps.openURL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I assert the title of the page",
  "keyword": "When "
});
formatter.match({
  "location": "TestingSteps.VerifyPageTitle()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on login",
  "keyword": "And "
});
formatter.match({
  "location": "TestingSteps.clickLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});