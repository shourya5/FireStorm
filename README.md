
# FireStorm

FireStorm is an extensible Java web server framework that can serve static webpages while also providing high level access to different parts of the FireStorm web server framework. For example,creating your own custom error codes and HTTP response and request errors can be done easily using FireStorm.



[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)


## Authors

- [@shourya5](https://github.com/shourya5)


## Features

- Easy to use framework for static websites
- High Level access to components such as HTTP error codes
- Cross platform


## Usage/Examples

```Java
public class main {
    public static void main(String[] args) {
        System.out.println("Starting server");
        HTTPServer server = new HTTPServer();
        server.startServer();
        System.out.println("Server connection closed");
    }
}
```
adding custom status codes,custom headers is as easy as updating the relevant headers ie. `HTTPHeaderResponse`, `DateHeader`, `ContentTypeHeader` etc.


## Environment Variables

To run this project, you will need to add the following environment variables to your .env file

`PORT` : this  is the port number that Firestorm will serve clients from

`PATH` : this is the path to your html file

There are default values set for both `PATH` and `PORT`,setting these environment variables should override them.
## License

[MIT](https://choosealicense.com/licenses/mit/)


## Contributing

Contributions are always welcome!

Pull requests are always welcome,and if you find a bug,open an issue higlighting the bug 


