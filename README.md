# IntegrationFramework
Connecting multiple data points into one data model never has been so easy. This library enables you to have multiple data sources and structure/combine them in a few simple steps.

## What does it do?
The integration framework "grabs" data sources and combines them into one model. Through what I call plug-ins creates a connection between a datasource/api and connects that to a assigned model that the user need. It is also possible to combine multiple data sources when they output the same model. You can have for example imdb and netflix outputting the same information in one view.

## How do you use it?
When you implement the framework (see next chapter). You can get the model from the 
Jerome.Run method. This will return a List<MainDataModel> you can then cast your own class to it to extract certain values
of the class.

#### URL protocol
To get information from the framework you can use a url to get information.
Commonly urls for the framework look like this:

maid://plugin-name/path/to/data?boolean=true

The first part of the url maid defines the protocol, the second part where normally the url comes, there we have the plugin name.
You can use multiple plugins at once. The url would then look like this:

maid://plugin1+plugin2/path/to/data?boolean=true

Now the data from both plugins will be combined into one model and will output this.

You can use the path for whatever you want. A path to a file or just a request to a website. You can also use the fragments
to set different parameters in the framework.

Look up per plug-in what the actual parameters are to extract data from it.

#### Executing the framework
You can run the framework by using the run method. The parameter in the run method will ask a String that contains a url.
From the String inputted in the run method will be a native java url be created so you have to type a certain string into the run method.
In the previous chapter is discussed on how to create a string query.

When the run method is finished it will return a list of objects(models) that implements the MainDataModel. You can use that to get data from a plug-in or multiple plug-ins.
You can also use libraries such as Gson to output the information as json when you are building a web api.

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
Create a new class and extend the abstract nl.mawoo.intergrationframework.engine.Plugin class.
Then create a constructor for the class. Any custom parameters for the plugin will not be loaded.

The super will ask for three parameters: 
* plugin name - the name the plug-in will be called in the protocol
* source url - what source is data coming from. this can be useful if you want to open data at a certain location
* description - what does the plug-in do?

Then you will have to override the query method. This method is executed when a request comes in. The query method has two
parameters. The first on is path this is the path that is requested in the url, and as a second parameter you have the fragment of the url: ?boolean=true part.
With these parameters you can handle all types of request to any data source or api.

Example 

```
public class MaidExamplePlugin extends Plugin {
    
    public MaidExamplePlugin() {
        super("exampe-plugin", "http://yourdomain.com/", "Example plugin on how to implement sources and use this framework.");
    }

    @Override
    public List<MainDataModel> query(String path, String query) {
        List<MainDataModel> output = new ArrayList<>();
        // Here I create a new DefaultModel the model implements the MainDataModel so we can use it to output information
        DefaultModel defaultModel = new DefaultModel(this.getName(), "requested path:"+ path, "query:"+ query);
        output.add(defaultModel);
        return output;
    }
}

```

If your Plugin is in the class path then it will automatically load into the framework. 
To see a more detailed version of the plugin go look at the MaidExamplePlugin class. There you will find more documentation.

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


## License 
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
