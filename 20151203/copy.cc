#include <iostream>
#include <fstream>


int main()
{
	std::ifstream  src("/Users/ourguide/Dropbox/sample.jpg", std::ios::binary);
	std::ofstream  dst("/Users/ourguide/Desktop/to.jpg",   std::ios::binary);

	dst << src.rdbuf();
}
