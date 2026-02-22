# *Module 2 CI/CD & DevOps*
Deployed url: https://flat-nat-a-samuel-marcelino-tindaon-2406435830-7209c7d2.koyeb.app/product/list
## Reflection
### Code Quality Issues
When using sonarqube, one of the code quality issues that I got was a security hotspot on my sonarqube CI pipeline. 
- Before, I wrote:
```bash
- name: Run SonarCloud analysis
        uses: SonarSource/sonarcloud-github-action@v2n
```
In this case, sonarqube said that stating @v2 was a security hotspot because:
- It is executing a third-party code
- It is pulled from GitHub
- It is inside a CI environment
- It may have access to the secret SONAR_TOKEN

A security hotspot by itself is not a vulnerability. However, it is a warning: running a third-party code has its own risks. The tag @v2 means that the external code I'm using may be subject to change and I won't be notified if I didn't check. This means that if the third-party code changes, it may cause unexpected errors in my repository. Worst case scenario is that the changes are malicious codes.

The solution sonarqube gave me is use the SHA that points directly to the commit/release of that third-party code:
```bash
- name: Run SonarCloud analysis
        uses: SonarSource/sonarcloud-github-action@ffc3010689be73b8e5ae0c57ce35968afd7909e8
```
This way, it guarantees that the third-party code that I'm using will not change and always point to that exact commit/release of that third-party code. Therefore, I won't have to worry if @v2 has changes to it.

### CI/CD workflow review
Based on the CI/CD workflows  currently have, I think they already implemented Continuous Integration and Continuous Deployment. First of all, tests are always ran on everytime changes are made. This automates testing and prevents human errors such as forgetting to test changes. Other than than, code quality is also checked by sonarqube and ossf scorecard. This means any code vulnerabilities, security hotspots, and code cleanliness are also checked everytime a change is commited. 

Continuous deployment is implemented on the branch main. It will automatically redeploy the project to Koyeb when changes are made in main. However, those changes are guarded by the CI before. This means if the changes failed the CI, then the project won't be deployed. 


# *Module 1 Coding Standards*

---
## Reflection 1
Clean code implementations:
- Meaningful Names. Variables are named in a way that represents the value it holds. Such as the following:
    ```java
    Product productToDelete = findById(productId);
    ``` 
    This variable acts as a placeholder for a Product class that is going to be deleted after a finding the product in the repository. It Doesn't need a comment to explain this, since the variable's name itself is self-explanatory.
- Functions, for example:
  ```java
  public void delete(String productId) {
        Product productToDelete = findById(productId);

        if (productToDelete != null) {
            productData.remove(productToDelete);
        }
    }
  ```
  The method's name is self-explanatory and it only does one task which is to delete. 
- There are no unnecessary comments. Using clean code promotes the clarity of variable names and function separation. This leads to a code that is self-explanatory and doesn't require comments to understand. 
- Layout and Formatting are done using indentations and separation of code blocks using blank lines. This makes the program much more readable.
- However, I haven't properly implemented error handling such as try-catches. Some of my methods still return null which can cause unexpected errors. This can be improved by using Optional classes to avoid returning null values.
## Reflection 2
- Unit tests should be done in a way that it covers all public methods of a class. If a method has various results, then we should make separate tests that exercises each distinct result of that method. That way, we can have increased code coverage. However, 100% code coverage doesn't mean that our code has no bugs or errors. Code coverage indicates the lines of code that are executed during testing. Correctness depends on what we wrote on the unit test. Human error may be present when writing down unit test assertions. Sometimes we can make wrong logical assertions, which would result in a passed test while having incorrect or unintended behaviour.   
- Since the new class has the exact same setup procedures and instance variables, the code won't adhere to clean code principles. The identical setup makes the code redundant. This issue can be avoided by checking the quantity of the product in the original file CreateProductFunctionalTest.java. We just need to add a few lines of code to verify the quantity. Creating a new Java class just to verify quantity is unnecessary. 
