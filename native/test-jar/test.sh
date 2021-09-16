#!/bin/bash

set -eou pipefail

cd "$(dirname "$0")"

if [ -z "$GRAALVM_HOME" ]; then
    echo "Please set GRAALVM_HOME"
    exit 1
fi

export JAVA_HOME=$GRAALVM_HOME
export PATH=$GRAALVM_HOME/bin:$PATH
# export DTLV_LIB_EXTRACT_DIR=/tmp

clojure -X:uberjar :jar target/test-jar.jar


"$GRAALVM_HOME/bin/native-image" \
    -jar target/test-jar.jar \
    jar-test

# -H:CLibraryPath=${DTLV_LIB_EXTRACT_DIR} \

./jar-test
