
# Steps To Setup Local Environment
## BE

 

 - Install IntelliJ IDEA Community Edition : https://www.jetbrains.com/idea/download/?section=windows
 - Install Git: https://git-scm.com/downloads
 - Clone the BE solution from: https://github.com/ivatuva/test_dashboard.git
 - Install docker desktop: https://www.docker.com/products/docker-desktop/
 - Install "Volumes Backup & Share" extension: https://hub.docker.com/extensions/docker/volumes-backup-extension
 - Setup containers:
	 - Open a new cmd windows in "Docker" folder. (Inside of the project folder from step 2)
	 - Execute the command `docker compose up`
	 - Verify that the cointainers are running
	 - Import the volumes stored in "Docker/Volumes" folder into the docker desktop by using the "Volumes" extension.
		 -  Volume name: api_dashboard_grafana-storage -> File name:  api_dashboard_grafana-storage.tar
		 - Volume name: api_dashboard_my-db -> File name:  api_dashboard_my-db.tar
	 - Restart the containers
 - Find the grafana dashboards on: http://localhost:3000/
	 - Credentials:
		 - username: admin
		 - password: admin1
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

	
 















