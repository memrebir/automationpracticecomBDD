
  Feature: Register and Order Feature
    Scenario: Register and Order
      Given Start Driver and Browser
      When Navigate to automationPractice homepage URL
      And Click to signIn button
      And I'm filling valid email address at Create an account menu
      Then Is the entered email valid?
      And I click create an account button
      And I'm filling personal information areas
      And I'm filling your address areas
      And I'm clicking register button
      Then Account successfully created


      And I'm clicking SummerDress Tab
      Then Product List page successfully loaded
      And I'm adding to chart any product
      Then Product is successfully added to your shopping chart


      And I'm clicking continue shopping button at cart view
      When I'm filling search text area
      And I'm clicking search button
      Then Search is successfully
      And I'm adding to chart any product
      Then Product is successfully added to your shopping chart


      And I'm clicking continue shopping button at cart view
      And I'm clicking Cart button
      Then Cart page is successfully loaded
      Then Are the products the ones I added?


      And I'm clicking proceed to checkout button at cart page
      And I'm clicking proceed the checkout button at address page
      When I'm checking terms of service checkbox
      And I'm clicking proceed the checkout button at shipping page
      And I'm clicking PayByBankWire option
      And I'm clicking I Confirm Order Button
      Then Is My Order Complete?


      And I'm clicking My Account Button
      And I'm clicking order history and details
      Then Order history order list control
