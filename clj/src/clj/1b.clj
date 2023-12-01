(ns clj.1b
  (:require [clj.input :as input]))

(defn calibration-value [line]
  (->> line
       (filter #(Character/isDigit %))
       ((juxt first last))
       (apply str)
       (Integer/parseInt)))

(->> (input/lines 1)
     (map calibration-value)
     (reduce +))