package jp.co.softem.apps.controller;

import org.slim3.controller.router.RouterImpl;

public class AppRouter extends RouterImpl {

    public AppRouter() {
        addRouting(
            "/{app}/edit/{key}/{version}",
            "/{app}/edit?key={key}&version={version}");
        addRouting(
            "/{app}/delete/{key}/{version}",
            "/{app}/delete?key={key}&version={version}");
    }
}
