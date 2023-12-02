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

(def word-or-digit-at-start (re-pattern (str "^("
                                             (s/join "|" (concat (keys word->digit)
                                                                 (vals word->digit)))
                                             ")")))

(defn calibration-value [line]
  (->> line
       (iterate rest)
       (take-while seq)
       (map #(apply str %))
       (keep #(first (re-find word-or-digit-at-start %)))
       (map #(get word->digit % %))
       ((juxt first last))
       (apply str)
       (Integer/parseInt)))

(->> (input/lines 1)
     (map calibration-value)
     (reduce +))
