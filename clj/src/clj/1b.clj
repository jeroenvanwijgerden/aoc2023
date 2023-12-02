(ns clj.1b
  (:require [clj.input :as input]
            [clojure.string :as s]))

(def word->digit
  {"one"   "1"
   "two"   "2"
   "three" "3"
   "four"  "4"
   "five"  "5"
   "six"   "6"
   "seven" "7"
   "eight" "8"
   "nine"  "9"})

(def word-or-digit (re-pattern (str "(?=("
                                    (s/join "|" (concat (keys word->digit)
                                                        (vals word->digit)))
                                    "))")))

(defn calibration-value [line]
  (->> line
       (re-seq word-or-digit)
       (map (comp #(get word->digit % %) second))
       ((juxt first last))
       (apply str)
       (Integer/parseInt)))

(->> (input/lines 1)
     (map calibration-value)
     (reduce +))
