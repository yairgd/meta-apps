# https://jumpnowtek.com/yocto/Add-golang-support-to-a-Yocto-build.html
SUMMARY = "A development image with a go program"
HOMEPAGE = "https://jumpnowtek.com"
LICENSE = "MIT"

#require core-image.bb

inherit core-image

GOLANG_STUFF = " \
    go-helloworld \
 "

IMAGE_INSTALL += " \
    ${GOLANG_STUFF} \
 "

export IMAGE_BASENAME = "go-image"
