def call(String credId, String imageName, String tag) {
    withCredentials([usernamePassword(
        credentialsId: credId,
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {
        sh "docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}"
        sh "docker tag ${imageName}:${tag} ${DOCKER_USER}/${imageName}:${tag}"
        sh "docker push ${DOCKER_USER}/${imageName}:${tag}"
    }
}
