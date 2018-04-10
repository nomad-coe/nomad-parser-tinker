# Tinker Parser
[NOMAD Laboratory CoE](http://nomad-coe.eu) parser for [TINKER](https://dasher.wustl.edu/tinker/)
## Version 0.0.3

This is the parser for Tinker in [TINKER](https://dasher.wustl.edu/tinker/).
The official version lives at:

    git@gitlab.mpcdf.mpg.de:nomad-lab/parser-tinker.git

You can browse it at:

    https://gitlab.rzg.mpg.de/nomad-lab/parser-tinker

It relies on having the nomad-meta-info and the python-common repositories one level higher.
The simplest way to have this is to check out nomad-lab-base recursively:

    git clone --recursive git@gitlab.mpcdf.mpg.de:nomad-lab/nomad-lab-base.git

This parser will be in the directory parsers/tinker of this repository.

## Running and Testing the Parser
### Requirements
The required python packages can be installed with (see [python-common](https://gitlab.rzg.mpg.de/nomad-lab/python-common)):

    pip install -r nomad-lab-base/python-common/requirements.txt

### Usage
Tinker MD log output files can be parsed with:

    python TINKERParser.py [path/toFile]

### Test Files
Example log output files of Tinker can be found in the directory test/examples.
More details about the calculations and files are explained in README file of test/examples.

