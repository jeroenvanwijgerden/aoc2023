(ns clj.input)

(defn raw [day]
  (slurp (str "resources/" day)))

(defn lines [day]
  (->> (raw day)
       (clojure.string/split-lines)))

