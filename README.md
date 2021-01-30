FunctionalTestingWithSeleniumBase

**Two common steps to invoke the Chrome browser
   >Setting the Properties and the Path
    Initialize browser
        
**How to handle when they ask you to find multiple product names?
   >Declare an Array in java
    Calling this Method, without creating an object of this class

**Create object of this class - But you dont need this line of code when you made the 'Method Static' you can directly access that method without creating an object thats the concept of Java
          /*Base base = new Base(); // No matter is you in the same class or any class, you need to access any method you need to
          //To call the Method
          base.addItems(driver, itemsNeeded);
           */

**Scenario to automate and necessity of waits in the example
>Creating a Method outside on the main Method       
>Sending Array of Product to Cart for checkout
Selecting all the matching Product lists from the cssSelector
Return type for findElement is WebElements = to return a list is List<WebElement>

**iterate to each and every index   
>Get one index out of the 30
 Store it in a variable
 format it to get actual vegetable name, pass it to the 'if condition' to check your array
 Convert array into array list for easy search (Is to save the memory)
 Check whether name you extracted is present in array or not
 Conversion of array to ArrayList
 using Arrays.asList

**if Loop
 >click on add to cart
  End the for loop abruptly
  break;
  For the 'if statement' to be Generic

**Implicit and Explicit 
>Is based on the search results
>When your code/test executes faster than your browser, test works with elements that are 
not there.

*Implicit Wait Machine: 
> ImplicitWait is applied Globally - in a global level, it's telling the program to Waiting for a number of seconds before throwing exception.
Initially it's saying, So whenever I tell my driver to click on something and the results are not found, please don't fail immediately,
wait for a number of seconds
Advantages: Defining it globally, so that is there is a 100 steps in your application then each and every step there is wait time, because you are
clicking 100 clicks which navigate to 100 pages, so each page has a time limit to load, so if you declare it once globally that that's it

*Explicit Wait:
>Is used to target specific Elements e.g specific to all location searches 

>Implicit and Explicit are both are combined used to achieve synchronization successfully in a realtime project.