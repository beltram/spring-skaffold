# spring-skaffold
Sample to set up a local continuous development of spring boot apps with skaffold
## Installation
### install skaffold
##### on linux
* ```curl -Lo skaffold https://storage.googleapis.com/skaffold/releases/latest/skaffold-linux-amd64 && chmod +x skaffold && sudo mv skaffold /usr/local/bin```
##### on mac
* ```curl -Lo skaffold https://storage.googleapis.com/skaffold/releases/latest/skaffold-darwin-amd64 && chmod +x skaffold && sudo mv skaffold /usr/local/bin```
### install docker
### install kubernetes
either minikube or docker for mac
## Still to do
* Improve startup time
    * Use slimmer gradle image
    * Start Spring Boot apps on GraalVM once [this issue](https://jira.spring.io/browse/SPR-16991) fixed
* Manage istio routes the clever way
* Manage infra components (mongo, redis, kafka...)
* Try skaffold parallel builds once [this issue](https://github.com/GoogleContainerTools/skaffold/issues/248) fixed 
* Base docker builder images have to be deleted on each build (issue on skaffold size)
* Find a smarter way to handle cache (currently a base docker image) could be fixed if skaffold allows passing options to docker build
* Add liveness and readiness probes to k8s services