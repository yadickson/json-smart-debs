# Debian Package for JSON Small and Fast Parser Project

[![TravisCI Status][travis-image]][travis-url]

**Build dependencies**

- debhelper (>= 9)
- cdbs
- default-jdk
- maven-debian-helper (>= 1.5)

**Download source code**

- unzip
- wget
- libc-bin
- dos2unix 

```
$ debian/rules get-orig-source
$ debian/rules publish-source
```

**Build project**

```
$ dpkg-buildpackage -rfakeroot -D -us -uc -i -I -sa
```
or
```
$ QUILT_PATCHES=debian/patches quilt push -a
$ fakeroot debian/rules clean binary
```

**Tested**

- Debian wheezy
- Debian jessie

**Note**

This packages is present since debian stretch.

**Repositories**

[Debian repository](https://bintray.com/yadickson/debian)

```
$ wget -qO - https://bintray.com/user/downloadSubjectPublicKey?username=bintray | sudo apt-key add -
```
```
$ echo "deb https://dl.bintray.com/yadickson/debian [distribution] main" | sudo tee -a /etc/apt/sources.list.d/bintray.list
```
```
$ sudo apt-get update
$ sudo apt-get upgrade -y
$ sudo apt-get install libjson-smart-java
```

## License

GPL-3.0 © [Yadickson Soto](https://github.com/yadickson)

Apache-2.0 © [netplex](https://github.com/netplex/json-smart-v1)

[travis-image]: https://api.travis-ci.org/yadickson/json-smart-debs.svg?branch=master
[travis-url]: https://travis-ci.org/yadickson/json-smart-debs

