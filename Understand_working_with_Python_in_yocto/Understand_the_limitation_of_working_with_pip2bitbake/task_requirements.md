# Objective
Demonstrate the limitations of using Pip2Bitbake to create recipes for installing python packages that do not exist on OpenEmbedded.

e.g. tensorflow packaging must be .tar.gz or .zip. Where packaging is .whl, error is returned by Pip2Bitbake
