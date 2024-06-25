
# Steps To Setup Local Environment
## BE

 

 - Install IntelliJ IDEA Community Edition : https://www.jetbrains.com/idea/download/?section=windows
 - Install Git: https://git-scm.com/downloads
 - Clone the BE solution from: https://github.com/ivatuva/test_dashboard.git
 - Install docker desktop: https://www.docker.com/products/docker-desktop/
 - Install "DBeaver Community": https://dbeaver.io/download/
 - Setup containers:
	 - Open a new cmd windows in "Docker" folder. (Inside of the project folder from step 2)
	 - Execute the command `docker compose up`
	 - Verify that the cointainers are running
    ![image](https://github.com/ivatuva/test_dashboard/assets/173475763/2005ccdd-c1a5-4cc4-9bce-fc776b7038d6)

 - Setup database:
 	- Open the DBeaver app
  	- Create a new 'mysql' connection with the following parameters:
   		- On 'Main' tab: 
   			- Host: localhost
     			- Port: 3306
        		- Username: root
          		- Password: root
            	- On 'Driver properties' tab:
             		- allowPublicKeyRetrieval = TRUE
       - Hit the 'Test Connection' button: ![image](https://github.com/ivatuva/test_dashboard/assets/173475763/cdf69a1e-f614-43a0-85e5-83159100704c)
 - Execute DB scripts
 	- On DBeaver app, hit the 'SQL' button
  	- Select your connection
   	- Select the 'dashboard' database ![image](https://github.com/ivatuva/test_dashboard/assets/173475763/4768fd18-4897-49f5-a4c6-81191b88934d)
   	- On the opened script tab, past the content from 'DB/scripts/BE.mysql' file
   	- Click on run button
   	- The script should be executed successfully ![image](https://github.com/ivatuva/test_dashboard/assets/173475763/1da74299-e0d2-4458-92e8-65eaaa23bfcb)
   	- Repeat the previous steps for 'DB/scripts/FE.mysql' and 'DB/scripts/Browser.mysql' files


 - Connect to grafana:
	 - Find the grafana dashboards on: http://localhost:3000/
	 	- Credentials:
			- username: admin
		 	- password: admin
    	- You will be asked to setup a new password:
		 - Password: admin1
   - Setup grafana dashboards:
   	- Go to your docker desktop app
   	- Containers
   	- Open the details of your MySQL container by clicking on its name: ![image](https://github.com/ivatuva/test_dashboard/assets/173475763/4598d1ff-6b26-48a5-96cc-e7862dfb0ec2)
   	- Navigate to 'Inspect' tab
   	- Filter by 'Networks'
   	- Find the 'IPAddress' value: ![image](https://github.com/ivatuva/test_dashboard/assets/173475763/58ec4538-b1c8-4dad-8b5a-1410e647fae8)
   	- Copy the ip address 
   	- Go back to grafana http://localhost:3000/
   	- Open connections
   	- Add a new connection
   	- Search for 'MySQL'
   	- Select the mysql result: ![image](https://github.com/ivatuva/test_dashboard/assets/173475763/4c051e5a-ddbd-4895-98c1-b8f412098569)
   	- Hit the 'Add New Data Source' button
   	- Fill the connection details with the following data:
   		- Host: Your container ip copied before
   	 	- Port: 3306
   	  	- Username: bliss
   	  	- Password: bliss
   	  	- ![image](https://github.com/ivatuva/test_dashboard/assets/173475763/663419b0-f715-4e17-8118-5e47198f3076)
   	 
	- Hit the 'Save & Test' button - can be found below - scroll down
![image](https://github.com/ivatuva/test_dashboard/assets/173475763/e665640d-4ac1-47e9-928b-0e994152b78b)

	- Navigate to dashboards
 	- Hit the 'New' dorpdown
  	- Select the 'import' option ![image](https://github.com/ivatuva/test_dashboard/assets/173475763/03c5659c-2f56-495c-8707-f931ccdc4622)
   	- Select the 'FE Dashboard.json' file located in the 'Dashboards' folder
   	- Hit the 'Import' button ![image](https://github.com/ivatuva/test_dashboard/assets/173475763/899565eb-66f7-4bba-af5b-f6f228d15505)
   	- The FE Dashboard should be displayed ![image](https://github.com/ivatuva/test_dashboard/assets/173475763/6f2948b6-060d-4774-bee2-987f6504c9e7)
   	- Navigate to dashboards, then repeate the previous steps to import the 'BE Dashboard.json' file.

 
- Run Tests
	- Comment all test methods using /* */ 
	- Click on Maven button located on the right side bar on you IDE
![image](https://github.com/ivatuva/test_dashboard/assets/173475763/c7ec5511-48d5-49c9-86b8-ebcc41e818ba)
	- Double click on install
 ![image](https://github.com/ivatuva/test_dashboard/assets/173475763/69347b0a-fbdf-4c1c-9029-653e38a2e339)
	- The output should be like:
![image](https://github.com/ivatuva/test_dashboard/assets/173475763/28b8bbf5-5e31-4ec3-b0fb-f0ca1cd2a4a1)

	- Uncomment the tests
 	- Click on Run button to execute the tests.   
![image](https://github.com/ivatuva/test_dashboard/assets/173475763/42d31655-649a-4e05-899b-46dda6e8a547)

	
 















