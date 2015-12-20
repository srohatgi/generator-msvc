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
      ['Application.java', 'src/main/java/com/' + folders + '/Application.java'],
      ['Person.java', 'src/main/java/com/' + folders + '/domain/Person.java'],
      ['PersonService.java', 'src/main/java/com/' + folders + '/services/PersonService.java'],
      ['PersonServiceImpl.java', 'src/main/java/com/' + folders + '/services/PersonServiceImpl.java'],
      ['PeopleController.java', 'src/main/java/com/' + folders + '/controllers/api/PeopleController.java'],
      ['PersonRepository.java', 'src/main/java/com/' + folders + '/dao/PersonRepository.java'],
      ['application.properties', 'resources/application.properties'],
      ['banner.txt', 'resources/banner.txt'],
      ['logback.xml', 'resources/logback.xml']
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
      ['build.gradle'],
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

      this.fs.copy(this.templatePath(src), this.destinationPath(dest));
    }, this);
  },

  install: function () {
    //this.installDependencies();
    this.spawnCommand('./gradlew', ['build']);
  }
});
