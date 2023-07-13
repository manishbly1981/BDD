Feature: Access the URSA Bank application and create a application for Business Commercial Mortgage

  @Regression
  Scenario Outline: Login into Customer Portal Application with defafult credential and create a business commercial mortage process using Data Driven

    Given Login into 'ncino' application for the <TestCaseId>


    Examples:
      |TestCaseId|
      |TP-13     |
