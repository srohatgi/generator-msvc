'use strict';
var path = require('path');
var assert = require('yeoman-assert');
var helpers = require('yeoman-generator').test;

describe('generator-msvc:app', function () {

  before(function (done) {
    this.timeout(15000);
    helpers.run(path.join(__dirname, '../generators/app'))
      .withPrompts({orgName: 'intocloudtech'})
      .on('end', done);
  });

  it('creates files', function () {
    assert.file([
      '.gitignore'
    ]);
  });
});
