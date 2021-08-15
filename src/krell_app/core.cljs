(ns krell-app.core
  (:require [reagent.core :as r]
            [re-frame.core :refer [dispatch]]
            [reagent.react-native :refer [button
                                          text
                                          view]]
            [krell-app.util :refer [<-sub]]
            ;; register events and subscriptions
            [krell-app.events]
            [krell-app.subs]))

(defn root []
  [view {:style {:flex 1 :align-items "center" :justify-content "center"}}
   [text {:style {:font-size 50 :color :blue}} (<-sub [:get-counter])]
   [button {:title    "Increment Counter"
            :on-press #(dispatch [:inc-counter])}]])

(comment
  re-frame.db/app-db)

(defn ^:export -main [& args]
  (r/as-element [root]))
