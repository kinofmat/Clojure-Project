;; This function will take a string representation of binary with wildcards.
;; It will replace the wildcards with either a 1 or a 0 to show all possible binary outcomes.

(defn biwild [template]
    (def wildcard (str 9)) ;; What to compare against for our wildcard. This could be any other number of items as the "wildcard"
    (if (.contains template wildcard)
        [ ;; Learned I needed the brackets for multiple blocks so it would not try to read them as a function call.
            (def binary template)
            ;; First change to a zero so it counts in order.
            (biwild (clojure.string/replace-first binary wildcard (str 0))) ;; Recursive call
            ;; Due to the immutable nature of variables in Clojure I needed to switch from "binary" to "template" here.
            (biwild (clojure.string/replace-first template wildcard (str 1)))
        ]
        (println template) ;; If there are no more wildcards we are at the end and want to see the results.
    )
)


(def x (str 1 0 9 9 0))
(biwild x) ;; Expect result: 10000, 10010, 10100, 10110

(biwild (str 9 9 9)) ;; Expected result: 000, 001, 010, 011, 100, 101, 110, 111