SUMMARY = "JSON C++ lib used to read and write json file."
DESCRIPTION = "Jsoncpp is an implementation of a JSON (http://json.org) reader \
               and writer in C++. JSON (JavaScript Object Notation) is a \
               lightweight data-interchange format. It is easy for humans to \
               read and write. It is easy for machines to parse and generate."

HOMEPAGE = "https://github.com/open-source-parsers/jsoncpp"

#SECTION = "libs"
DEPENDS = " asio catch2 "

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=36f8a3bd5084413aa017059ccd1a2d78"

SRCREV = "f74f9329dac82e662c1d570b7cd72c192b729eb4"
SRC_URI = "gitsm://github.com/corvusoft/restbed;branch=master;"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "-DBUILD_SSL=NO"
