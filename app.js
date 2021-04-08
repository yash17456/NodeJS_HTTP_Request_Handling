var express = require('express');

var app = express();

app.listen(3000);

app.get('/Combinations/:id', function(req, res){

  var input = req.params.id;
  //var result;
  const fs = require('fs');
  fs.writeFile('input.txt', input, function(err){
    if(err){
      return console.log(err);
    }
    console.log("The file was saved");
  });
  let childProcess = require('child_process').spawn(
        'java', ['-jar', __dirname + '/LetterCombinationsOfNumber.jar']
      );

  childProcess.stdout.on('data', function(data) {
      //result = data.toString ('utf8');
      console.log(data.toString ('utf8'));
      res.send(data.toString ('utf8'));
  });

  childProcess.stderr.on("data", function (data) {
      //result = data.toString ('utf8');
      console.log(data.toString ('utf8'));
      res.send(data.toString ('utf8'));
  });

})

console.log('server is running');
