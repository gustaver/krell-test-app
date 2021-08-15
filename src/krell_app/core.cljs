(ns krell-app.core
  (:require [reagent.core :as r]
            [reagent.react-native :as rn]
            [re-frame.core :as rf]
            [krell-app.util :refer [<-sub]]
            [krell-app.subs]
            [krell-app.events]))

(defn root []
  [rn/view {:style {:flex 1 :align-items "center" :justify-content "center"}}
   [rn/text {:style {:font-size 50}} (<-sub [:get-counter])]
   [rn/button {:title "Increment Counter"
               :on-press #(rf/dispatch [:inc-counter])}]])

(defn ^:export -main [& args]
  (rf/dispatch-sync [:initialize-db])
  (r/as-element [root]))
