@Grab('com.aestasit.infrastructure.sshoogr:sshoogr:0.9.26')
import static com.aestasit.infrastructure.ssh.DefaultSsh.*

trustUnknownHosts = true

  execOptions.with {
    showOutput = true
    failOnError = false
    hideSecrets = true
    secrets = ['pepito']
    succeedOnExitStatus = 0
    maxWait = 10000
  }
remoteSession ('jordi@localhost:22') {
    keyFile =  new File( "./.ssh/id_rsa" )
    connect()
    exec 'ls -la'

   exec 'echo pepito | sudo -S -i systemctl status crond '
  // exec 'sudo systemctl status'
    exec 'ls -la'
    disconnect()
}