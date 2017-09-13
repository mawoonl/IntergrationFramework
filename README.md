# IntergrationFramework
Connecting multiple data points into one data model never has been so easy. This library enables you to have multiple data sources and structure/combine them in a few simple steps.

## What does it do?
The intergration framework "grabs" data sources and combines them into one model. Through what I call plug-ins creates a connection between a datasource/api and connectes that to a assigned model that the user need. It is also possible to combine multiple data sources when they output the same model. You can have for example imdb and netflix outputting the same information in one view.

## How do you use it?


## Integration with Java applications like Spring
Use maven or gradle to import the library.

Maven:
```
todo: maven code
```
Gradle
```
todo: gradle code
```
Create a new instance:
```
Jerome framework = new Jerome("package location (can be empty");
// Run the intergration framework
// returns a list of data
List<MainDataModel> model = framework.run("maid://plugin-name/path/to/data?custom=parameter");
//do whatever you want
```


## How to create new plug-ins
todo
## How to create new data model
To create a new data model you simple create a java object for example:
```
class FileModel implements MainDataModel {
  private String _source;
  private String filename;
  private String author;
  
  public FileModel(String _source, filename, author) {
    this._source = _source;
    ...
  }
  
 public String getSource() {
    return this._source;
 }
}
```
You can create a data model where ever you like if you just extend the MainDataModel class. The framework will automaticly output a json array with your items in the model.


## license 
```
Copyright 2017 Mawoo Nederland

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
