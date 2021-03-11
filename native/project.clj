(def version "0.4.25")

(defproject datalevin-native version
  :description "Datalevin GraalVM native image and command line tool"
  :parent-project {:path    "../project.clj"
                   :inherit [:managed-dependencies :profiles :jvm-opts
                             :deploy-repositories :global-vars :javac-options]}
  :dependencies [[org.clojure/clojure]
                 [org.clojure/tools.cli]
                 [persistent-sorted-set]
                 [borkdude/sci]
                 [com.taoensso/nippy]
                 [org.graalvm.sdk/graal-sdk]
                 [org.graalvm.nativeimage/svm]
                 [org.lmdbjava/lmdbjava]
                 [org.clojure/test.check]]
  :source-paths ["src/clj" "../src" "../test"]
  :java-source-paths ["src/java"]
  :test-paths ["../test"]
  :plugins [[lein-parent "0.3.8"]]
  )
