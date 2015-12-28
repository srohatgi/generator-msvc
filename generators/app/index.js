'use strict';

var yeoman = require('yeoman-generator');
var chalk = require('chalk');
var yosay = require('yosay');

module.exports = yeoman.generators.Base.extend({
  prompting: function () {
    var done = this.async();

    // Have Yeoman greet the user.
    this.log(yosay(
      'Welcome to the tiptop ' + chalk.yellow('msvc') + ' generator!'
    ));

    var prompts = [{
      type: 'text',
      name: 'orgName',
      message: 'organization package name:',
      default: 'intocloudtech'
    }];

    this.prompt(prompts, function (props) {
      this.props = props;
      // To access props later use this.props.someOption;

      done();
    }.bind(this));
  },

  writing: function () {
    var folders = this.props.orgName.replace('.', '/');
    [
      ['build.gradle', 'build.gradle'],
      ['Application.java', 'src/main/java/com/' + folders + '/Application.java'],
      ['Person.java', 'src/main/java/com/' + folders + '/domain/Person.java'],
      ['PersonService.java', 'src/main/java/com/' + folders + '/services/PersonService.java'],
      ['PersonServiceImpl.java', 'src/main/java/com/' + folders + '/services/PersonServiceImpl.java'],
      ['PeopleController.java', 'src/main/java/com/' + folders + '/controllers/api/PeopleController.java'],
      ['PersonRepository.java', 'src/main/java/com/' + folders + '/dao/PersonRepository.java'],
      ['application.properties', 'src/main/resources/application.properties'],
      ['banner.txt', 'src/main/resources/banner.txt'],
      ['logback.xml', 'src/main/resources/logback.xml'],
      ['101splunk-forwarder.config', 'src/main/resources/ebextensions/101splunk-forwarder.config']
    ].forEach(function (info) {
      var src = info[0];
      var dest = info[0];
      if (info.length === 2) {
        dest = info[1];
      }

      this.fs.copyTpl(
        this.templatePath(src),
        this.destinationPath(dest),
        {
          orgName: this.props.orgName
        }
      );
    }, this);
  },

  projectfiles: function () {
    [
      ['_gitignore', '.gitignore'],
      ['README.md'],
      ['gradlew'],
      ['gradlew.bat'],
      ['gradle/wrapper/gradle-wrapper.properties'],
      ['gradle/wrapper/gradle-wrapper.jar']
    ].forEach(function (info) {
      var src = info[0];
      var dest = info[0];
      if (info.length === 2) {
        dest = info[1];
      }

      this.fs.copy(
        this.templatePath(src),
        this.destinationPath(dest));
    }, this);
  },

  install: function () {
    //this.installDependencies();
    this.spawnCommand('./gradlew', ['build']);
  }
});
