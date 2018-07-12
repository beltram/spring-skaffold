# spring-skaffold
Sample to set up a local continuous development of spring boot apps with skaffold
## Installation
### install skaffold
##### on linux
* ```curl -Lo skaffold https://storage.googleapis.com/skaffold/releases/latest/skaffold-linux-amd64 && chmod +x skaffold && sudo mv skaffold /usr/local/bin```
##### on mac
* ```curl -Lo skaffold https://storage.googleapis.com/skaffold/releases/latest/skaffold-darwin-amd64 && chmod +x skaffold && sudo mv skaffold /usr/local/bin```
### install docker and local kubernetes
either minikube or docker for mac (for kubernetes). Optionally install istio
## Use gradle cache
Skaffold does not allow currently to pass options to docker build. Thus it prevents us from creating a volume containing gradle cache.
The current workaround is to locally build a docker image with gradle local cached artifacts and use it as a base image
  
* Go to your gradle home folder. Should be a .gradle folder ($HOME/.gradle on mac)  
* Go to caches/modules-2/files-2.1  
* As pushing context to docker daemon might take time, it would be a good idea to clear your gradle cache (delete everything in this folder)  
* Copy [this dockerfile](dockerfiles/Dockerfile-gradle-cache)
* Then execute ```docker build -t gradle-cache:latest .```  
## Run
At project root
* Run once
    * ```skaffold run```
* Continuous development
    * ```skaffold dev```
#### Tips
* To cleanup dangling docker images (especially if running skaffold dev) just run ```docker system prune```
## Still to do
* Improve startup time
    * Use slimmer gradle image
    * Use latest gradle (4.9-rc)
    * Fix gradle plugins not picked from cache
    * Start Spring Boot apps on GraalVM once [this issue](https://jira.spring.io/browse/SPR-16991) fixed
* Manage istio routes the clever way
* Manage infra components (mongo, redis, kafka...)
* Try skaffold parallel builds once [this issue](https://github.com/GoogleContainerTools/skaffold/issues/248) fixed 
* Base docker builder images have to be deleted on each build (issue on skaffold size)
* Find a smarter way to handle cache (currently a base docker image) could be fixed if skaffold allows passing options to docker build
* Add liveness and readiness probes to k8s services
* Try micronaut & Spring Fu also
* Try bazel as build tool
* Add label to builder images
* Try jib
* Try distroless
* Single dockerfile
## Links
* [Skaffold annotated](https://github.com/GoogleContainerTools/skaffold/blob/master/examples/annotated-skaffold.yaml)