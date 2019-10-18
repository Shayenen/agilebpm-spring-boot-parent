/*! AGILE-BPM 版权所有，翻版必究 */
!function (modules) {
    function __webpack_require__(moduleId) {
        if (installedModules[moduleId]) return installedModules[moduleId].exports;
        var module = installedModules[moduleId] = {i: moduleId, l: !1, exports: {}};
        return modules[moduleId].call(module.exports, module, module.exports, __webpack_require__), module.l = !0, module.exports
    }

    var installedModules = {};
    __webpack_require__.m = modules, __webpack_require__.c = installedModules, __webpack_require__.d = function (exports, name, getter) {
        __webpack_require__.o(exports, name) || Object.defineProperty(exports, name, {
            configurable: !1,
            enumerable: !0,
            get: getter
        })
    }, __webpack_require__.n = function (module) {
        var getter = module && module.__esModule ? function () {
            return module.default
        } : function () {
            return module
        };
        return __webpack_require__.d(getter, "a", getter), getter
    }, __webpack_require__.o = function (object, property) {
        return Object.prototype.hasOwnProperty.call(object, property)
    }, __webpack_require__.p = "", __webpack_require__(__webpack_require__.s = 36)
}({
    36: function (module, exports, __webpack_require__) {
        __webpack_require__(37), __webpack_require__(38), __webpack_require__(39), __webpack_require__(40)
    }, 37: function (module, exports) {
        !function ($, window, document, undefined) {
            function Plugin(element, options) {
                this.element = $(element), this.settings = $.extend({}, defaults, options), this._defaults = defaults, this._name = pluginName, this.init()
            }

            var pluginName = "metisMenu", defaults = {toggle: !0, doubleTapToGo: !1};
            Plugin.prototype = {
                init: function () {
                    var $this = this.element, $toggle = this.settings.toggle, obj = this;
                    this.isIE() <= 9 ? ($this.find("li.active").has("ul").children("ul").collapse("show"), $this.find("li").not(".active").has("ul").children("ul").collapse("hide")) : ($this.find("li.active").has("ul").children("ul").addClass("collapse in"), $this.find("li").not(".active").has("ul").children("ul").addClass("collapse")), obj.settings.doubleTapToGo && $this.find("li.active").has("ul").children("a").addClass("doubleTapToGo"), $this.find("li").has("ul").children("a").on("click." + pluginName, function (e) {
                        if (e.preventDefault(), obj.settings.doubleTapToGo && obj.doubleTapToGo($(this)) && "#" !== $(this).attr("href") && "" !== $(this).attr("href")) return e.stopPropagation(), void (document.location = $(this).attr("href"));
                        $(this).parent("li").toggleClass("active").children("ul").collapse("toggle"), $toggle && $(this).parent("li").siblings().removeClass("active").children("ul.in").collapse("hide")
                    })
                }, isIE: function () {
                    for (var v = 3, div = document.createElement("div"), all = div.getElementsByTagName("i"); div.innerHTML = "\x3c!--[if gt IE " + ++v + "]><i></i><![endif]--\x3e", all[0];) return v > 4 ? v : void 0
                }, doubleTapToGo: function (elem) {
                    var $this = this.element;
                    return elem.hasClass("doubleTapToGo") ? (elem.removeClass("doubleTapToGo"), !0) : elem.parent().children("ul").length ? ($this.find(".doubleTapToGo").removeClass("doubleTapToGo"), elem.addClass("doubleTapToGo"), !1) : void 0
                }, remove: function () {
                    this.element.off("." + pluginName), this.element.removeData(pluginName)
                }
            }, $.fn[pluginName] = function (options) {
                return this.each(function () {
                    var el = $(this);
                    el.data(pluginName) && el.data(pluginName).remove(), el.data(pluginName, new Plugin(this, options))
                }), this
            }
        }(jQuery, window, document)
    }, 38: function (module, exports) {
        !function (f) {
            jQuery.fn.extend({
                slimScroll: function (h) {
                    var a = f.extend({
                        width: "auto",
                        height: "250px",
                        size: "4px",
                        color: "#000",
                        position: "right",
                        distance: "1px",
                        start: "top",
                        opacity: .4,
                        alwaysVisible: !1,
                        disableFadeOut: !1,
                        railVisible: !1,
                        railColor: "#333",
                        railOpacity: .2,
                        railDraggable: !0,
                        railClass: "slimScrollRail",
                        barClass: "slimScrollBar",
                        wrapperClass: "slimScrollDiv",
                        allowPageScroll: !1,
                        wheelStep: 20,
                        touchScrollStep: 200,
                        borderRadius: "7px",
                        railBorderRadius: "7px"
                    }, h);
                    return this.each(function () {
                        function r(d) {
                            if (s) {
                                d = d || window.event;
                                var c = 0;
                                d.wheelDelta && (c = -d.wheelDelta / 120), d.detail && (c = d.detail / 3), f(d.target || d.srcTarget || d.srcElement).closest("." + a.wrapperClass).is(b.parent()) && m(c, !0), d.preventDefault && !k && d.preventDefault(), k || (d.returnValue = !1)
                            }
                        }

                        function m(d, f, h) {
                            k = !1;
                            var e = d, g = b.outerHeight() - c.outerHeight();
                            f && (e = parseInt(c.css("top")) + d * parseInt(a.wheelStep) / 100 * c.outerHeight(), e = Math.min(Math.max(e, 0), g), e = 0 < d ? Math.ceil(e) : Math.floor(e), c.css({top: e + "px"})), l = parseInt(c.css("top")) / (b.outerHeight() - c.outerHeight()), e = l * (b[0].scrollHeight - b.outerHeight()), h && (e = d, d = e / b[0].scrollHeight * b.outerHeight(), d = Math.min(Math.max(d, 0), g), c.css({top: d + "px"})), b.scrollTop(e), b.trigger("slimscrolling", ~~e), v(), p()
                        }

                        function w() {
                            u = Math.max(b.outerHeight() / b[0].scrollHeight * b.outerHeight(), D), c.css({height: u + "px"});
                            var a = u == b.outerHeight() ? "none" : "block";
                            c.css({display: a})
                        }

                        function v() {
                            w(), clearTimeout(A), l == ~~l ? (k = a.allowPageScroll, B != l && b.trigger("slimscroll", 0 == ~~l ? "top" : "bottom")) : k = !1, B = l, u >= b.outerHeight() ? k = !0 : (c.stop(!0, !0).fadeIn("fast"), a.railVisible && g.stop(!0, !0).fadeIn("fast"))
                        }

                        function p() {
                            a.alwaysVisible || (A = setTimeout(function () {
                                a.disableFadeOut && s || x || y || (c.fadeOut("slow"), g.fadeOut("slow"))
                            }, 1e3))
                        }

                        var s, x, y, A, z, u, l, B, D = 30, k = !1, b = f(this);
                        if (b.parent().hasClass(a.wrapperClass)) {
                            var n = b.scrollTop(), c = b.parent().find("." + a.barClass),
                                g = b.parent().find("." + a.railClass);
                            if (w(), f.isPlainObject(h)) {
                                if ("height" in h && "auto" == h.height) {
                                    b.parent().css("height", "auto"), b.css("height", "auto");
                                    var q = b.parent().parent().height();
                                    b.parent().css("height", q), b.css("height", q)
                                }
                                if ("scrollTo" in h) n = parseInt(a.scrollTo); else if ("scrollBy" in h) n += parseInt(a.scrollBy); else if ("destroy" in h) return c.remove(), g.remove(), void b.unwrap();
                                m(n, !1, !0)
                            }
                        } else {
                            a.height = "auto" == a.height ? b.parent().height() : a.height, n = f("<div></div>").addClass(a.wrapperClass).css({
                                position: "relative",
                                width: a.width,
                                height: a.height
                            }), b.css({width: a.width, height: a.height});
                            var g = f("<div></div>").addClass(a.railClass).css({
                                width: a.size,
                                height: "100%",
                                position: "absolute",
                                top: 0,
                                display: a.alwaysVisible && a.railVisible ? "block" : "none",
                                "border-radius": a.railBorderRadius,
                                background: a.railColor,
                                opacity: a.railOpacity,
                                zIndex: 90
                            }), c = f("<div></div>").addClass(a.barClass).css({
                                background: a.color,
                                width: a.size,
                                position: "absolute",
                                top: 0,
                                opacity: a.opacity,
                                display: a.alwaysVisible ? "block" : "none",
                                "border-radius": a.borderRadius,
                                BorderRadius: a.borderRadius,
                                MozBorderRadius: a.borderRadius,
                                WebkitBorderRadius: a.borderRadius,
                                zIndex: 99
                            }), q = "right" == a.position ? {right: a.distance} : {left: a.distance};
                            g.css(q), c.css(q), b.wrap(n), b.parent().append(c), b.parent().append(g), a.railDraggable && c.bind("mousedown", function (a) {
                                var b = f(document);
                                return y = !0, t = parseFloat(c.css("top")), pageY = a.pageY, b.bind("mousemove.slimscroll", function (a) {
                                    currTop = t + a.pageY - pageY, c.css("top", currTop), m(0, c.position().top, !1)
                                }), b.bind("mouseup.slimscroll", function (a) {
                                    y = !1, p(), b.unbind(".slimscroll")
                                }), !1
                            }).bind("selectstart.slimscroll", function (a) {
                                return a.stopPropagation(), a.preventDefault(), !1
                            }), g.hover(function () {
                                v()
                            }, function () {
                                p()
                            }), c.hover(function () {
                                x = !0
                            }, function () {
                                x = !1
                            }), b.hover(function () {
                                s = !0, v(), p()
                            }, function () {
                                s = !1, p()
                            }), b.bind("touchstart", function (a, b) {
                                a.originalEvent.touches.length && (z = a.originalEvent.touches[0].pageY)
                            }), b.bind("touchmove", function (b) {
                                k || b.originalEvent.preventDefault(), b.originalEvent.touches.length && (m((z - b.originalEvent.touches[0].pageY) / a.touchScrollStep, !0), z = b.originalEvent.touches[0].pageY)
                            }), w(), "bottom" === a.start ? (c.css({top: b.outerHeight() - c.outerHeight()}), m(0, !0)) : "top" !== a.start && (m(f(a.start).position().top, null, !0), a.alwaysVisible || c.hide()), function () {
                                window.addEventListener ? (this.addEventListener("DOMMouseScroll", r, !1), this.addEventListener("mousewheel", r, !1), this.addEventListener("MozMousePixelScroll", r, !1)) : document.attachEvent("onmousewheel", r)
                            }()
                        }
                    }), this
                }
            }), jQuery.fn.extend({slimscroll: jQuery.fn.slimScroll})
        }(jQuery)
    }, 39: function (module, exports) {
        function NavToggle() {
            $(".navbar-minimalize").trigger("click")
        }

        function SmoothlyMenu() {
            $("body").hasClass("mini-navbar") ? $("body").hasClass("fixed-sidebar") ? ($("#side-menu").hide(), setTimeout(function () {
                $("#side-menu").fadeIn(500)
            }, 300)) : $("#side-menu").removeAttr("style") : ($("#side-menu").hide(), setTimeout(function () {
                $("#side-menu").fadeIn(500)
            }, 100))
        }

        $(document).ready(function () {
            function fix_height() {
                var heightWithoutNavbar = $("body > #wrapper").height() - 61;
                $(".sidebard-panel").css("min-height", heightWithoutNavbar + "px")
            }

            $("#side-menu").metisMenu(), $(".right-sidebar-toggle").click(function () {
                $("#right-sidebar").toggleClass("sidebar-open")
            }), $(".sidebar-container").slimScroll({height: "100%", railOpacity: .4, wheelStep: 10}), $(function () {
                $(".sidebar-collapse").slimScroll({height: "100%", railOpacity: .9, alwaysVisible: !1})
            }), $(".navbar-minimalize").click(function () {
                $("body").toggleClass("mini-navbar"), SmoothlyMenu()
            }), fix_height(), $(window).bind("load resize click scroll", function () {
                $("body").hasClass("body-small") || fix_height()
            }), $(window).scroll(function () {
                $(window).scrollTop() > 0 && !$("body").hasClass("fixed-nav") ? $("#right-sidebar").addClass("sidebar-top") : $("#right-sidebar").removeClass("sidebar-top")
            }), $(".full-height-scroll").slimScroll({height: "100%"}), $("#side-menu>li").click(function () {
                $("body").hasClass("mini-navbar") && NavToggle()
            }), $("#side-menu>li li a").click(function () {
                $(window).width() < 769 && NavToggle()
            }), $(".nav-close").click(NavToggle), /(iPhone|iPad|iPod|iOS)/i.test(navigator.userAgent) && $("#content-main").css("overflow-y", "auto")
        }), $(window).bind("load resize", function () {
            $(this).width() < 769 && ($("body").addClass("mini-navbar"), $(".navbar-static-side").fadeIn())
        })
    }, 40: function (module, exports) {
        function calSumWidth(elements) {
            var width = 0;
            return $(elements).each(function () {
                width += $(this).outerWidth(!0)
            }), width
        }

        function scrollToTab(element) {
            var marginLeftVal = calSumWidth($(element).prevAll()), marginRightVal = calSumWidth($(element).nextAll()),
                tabOuterWidth = calSumWidth($(".content-tabs").children().not(".J_menuTabs")),
                visibleWidth = $(".content-tabs").outerWidth(!0) - tabOuterWidth, scrollVal = 0;
            if ($(".page-tabs-content").outerWidth() < visibleWidth) scrollVal = 0; else if (marginRightVal <= visibleWidth - $(element).outerWidth(!0) - $(element).next().outerWidth(!0)) {
                if (visibleWidth - $(element).next().outerWidth(!0) > marginRightVal) {
                    scrollVal = marginLeftVal;
                    for (var tabElement = element; scrollVal - $(tabElement).outerWidth() > $(".page-tabs-content").outerWidth() - visibleWidth;) scrollVal -= $(tabElement).prev().outerWidth(), tabElement = $(tabElement).prev()
                }
            } else marginLeftVal > visibleWidth - $(element).outerWidth(!0) - $(element).prev().outerWidth(!0) && (scrollVal = marginLeftVal - $(element).prev().outerWidth(!0));
            $(".page-tabs-content").animate({marginLeft: 0 - scrollVal + "px"}, "fast")
        }

        function scrollTabLeft() {
            var marginLeftVal = Math.abs(parseInt($(".page-tabs-content").css("margin-left"))),
                tabOuterWidth = calSumWidth($(".content-tabs").children().not(".J_menuTabs")),
                visibleWidth = $(".content-tabs").outerWidth(!0) - tabOuterWidth, scrollVal = 0;
            if ($(".page-tabs-content").width() < visibleWidth) return !1;
            for (var tabElement = $(".J_menuTab:first"), offsetVal = 0; offsetVal + $(tabElement).outerWidth(!0) <= marginLeftVal;) offsetVal += $(tabElement).outerWidth(!0), tabElement = $(tabElement).next();
            if (offsetVal = 0, calSumWidth($(tabElement).prevAll()) > visibleWidth) {
                for (; offsetVal + $(tabElement).outerWidth(!0) < visibleWidth && tabElement.length > 0;) offsetVal += $(tabElement).outerWidth(!0), tabElement = $(tabElement).prev();
                scrollVal = calSumWidth($(tabElement).prevAll())
            }
            $(".page-tabs-content").animate({marginLeft: 0 - scrollVal + "px"}, "fast")
        }

        function scrollTabRight() {
            var marginLeftVal = Math.abs(parseInt($(".page-tabs-content").css("margin-left"))),
                tabOuterWidth = calSumWidth($(".content-tabs").children().not(".J_menuTabs")),
                visibleWidth = $(".content-tabs").outerWidth(!0) - tabOuterWidth, scrollVal = 0;
            if ($(".page-tabs-content").width() < visibleWidth) return !1;
            for (var tabElement = $(".J_menuTab:first"), offsetVal = 0; offsetVal + $(tabElement).outerWidth(!0) <= marginLeftVal;) offsetVal += $(tabElement).outerWidth(!0), tabElement = $(tabElement).next();
            for (offsetVal = 0; offsetVal + $(tabElement).outerWidth(!0) < visibleWidth && tabElement.length > 0;) offsetVal += $(tabElement).outerWidth(!0), tabElement = $(tabElement).next();
            (scrollVal = calSumWidth($(tabElement).prevAll())) > 0 && $(".page-tabs-content").animate({marginLeft: 0 - scrollVal + "px"}, "fast")
        }

        angular.module("app", ["base"]).controller("indexCtrl", ["$scope", "baseService", function (scope, baseService) {
            scope.getUserMsg = function () {
                baseService.post(__ctx + "/org/userResource/userMsg", {}).then(function (result) {
                    if (!result.isOk && "401" === result.code) return void (window.location = "login.html");
                    result.isOk || $.Toast.error(result.msg), scope.userMsg = FastJson.format(result).data, scope.userRes = scope.userMsg.userMenuList, top.subSystem = {};
                    for (var s, i = 0; s = scope.userMsg.subsystemList[i++];) top.subSystem[s.alias] = s;
                    window.localStorage && (window.localStorage.setItem("buttonPermision", JSON.stringify(scope.userMsg.buttonPermision)), console.info(window.localStorage.buttonPermision));
                    var menuId = $.getCookie("default_menu"), currentMenu = null;
                    if (menuId && scope.userRes) for (var m, i = 0; m = scope.userRes[i++];) if (m.id == menuId) {
                        currentMenu = m;
                        break
                    }
                    !currentMenu && scope.userRes && (currentMenu = scope.userRes[0]), scope.topClick(currentMenu)
                }, function (aa) {
                })
            }, scope.getUserMsg(), scope.topClick = function (topMenu) {
                if (topMenu) {
                    topMenu.children && topMenu.children.length > 0 && ($.setCookie("default_menu", topMenu.id), scope.memus = topMenu.children);
                    for (var i = 0; i < scope.userRes.length; i++) {
                        var obj = scope.userRes[i];
                        obj.active = topMenu == obj ? "menuActive" : ""
                    }
                    window.setTimeout(function () {
                        $("#side-menu").metisMenu()
                    }, 10)
                }
            }, scope.menuClick = function (menu, noReload) {
                if (menu.url) {
                    -1 != menu.url.indexOf("http") && (noReload = !0);
                    for (var m, hasOpened = !1, i = 0; m = scope.openedMenu[i++];) m.active = "", m == menu && (noReload || scope.relaodIfream(menu), hasOpened = !0);
                    menu.active = "active", hasOpened || scope.openedMenu.push(menu), noReload || window.setTimeout(function () {
                        $("#" + menu.id + "iframe")[0]
                    }, 2)
                }
            }, scope.relaodIfream = function (menu) {
                $("#" + menu.id + "iframe")[0].contentWindow.location.reload()
            }, scope.closeTab = function (menu) {
                for (var m, idx = 0, i = 0; m = scope.openedMenu[i++];) if (m == menu) {
                    idx = i;
                    break
                }
                "active" == menu.active && (scope.openedMenu[idx - 2].active = "active") && (menu.active = '');
                var $frame = $("#" + menu.id + "iframe");
                try {
                    $frame[0].contentWindow.document.write(""), $frame[0].contentWindow.close()
                } catch (e) {
                }
                scope.openedMenu.splice(idx - 1, 1)
            }, scope.getEnviroment = function () {
                return scope.userMsg ? "DEV" === scope.userMsg.currentEnviroment ? " | 开发" : "SIT" === scope.userMsg.currentEnviroment ? " | 测试" : "UAT" === scope.userMsg.currentEnviroment ? " | 用户测试" : "GRAY" === scope.userMsg.currentEnviroment ? " | 灰度" : "" : ""
            }, scope.changeCurrentSystem = function (system) {
                if (system.url) return void window.open(system.url, system.openType || "_top");
                var get = baseService.get(__ctx + "/userResource/changeSystem?systemAlias=" + system.alias);
                $.getResultData(get, function () {
                    window.location = "index.html"
                })
            }, scope.changeCurrentOrg = function (orgId) {
                var get = baseService.get(__ctx + "/userResource/changeOrg?orgId=" + orgId);
                $.getResultData(get, function () {
                    window.location = "index.html"
                })
            }, scope.logout = function (systemId) {
                var get = baseService.get(__ctx + "/logout");
                $.getResultData(get, function () {
                    window.location = "login.html"
                })
            }, scope.closeAll = function () {
                scope.openedMenu = [{
                    id: "indexpage",
                    active: "active",
                    name: "首页",
                    noclose: !0,
                    url: "sys/workbenchPanel/myWorkbench.html"
                }]
            }, scope.cloaseOther = function () {
                for (var item, array = [{
                    id: "indexpage",
                    active: "active",
                    name: "首页",
                    noclose: !0,
                    url: "sys/workbenchPanel/myWorkbench.html"
                }], i = 0; item = scope.openedMenu[i++];) "active" === item.active && "首页" !== item.name && array.push(item);
                scope.openedMenu = array
            }, scope.closeOthers = function () {
                for (var item, array = [{
                    id: "indexpage",
                    active: "active",
                    name: "首页",
                    noclose: !0,
                    url: "sys/workbenchPanel/myWorkbench.html"
                }], i = 0; item = scope.openedMenu[i++];) "active" === item.active && "首页" !== item.name && array.push(item);
                scope.openedMenu = array
            }, scope.scrollCurrent = function () {
                for (var item, i = 0; item = scope.openedMenu[i++];) if ("active" === item.active) return void scrollToTab($("#" + item.id))
            }, scope.openedMenu = [{
                id: "indexpage",
                active: "active",
                name: "首页",
                noclose: !0,
                url: "sys/workbenchPanel/myWorkbench.html"
            }], $(".J_tabLeft").on("click", scrollTabLeft), $(".J_tabRight").on("click", scrollTabRight), window.setTimeout(function () {
                $("#indexpageiframe").attr("src", "sys/workbenchPanel/myWorkbench.html")
            }, 10);
            var userInfoTab = {id: "userInfo", name: "个人信息", icon: "fa-user", closable: !0};
            scope.userInfo = function () {
                userInfoTab.url = "org/user/userDetail.html?id=" + scope.userMsg.user.id, scope.menuClick(userInfoTab)
            };
            var editPassworldTab = {id: "editPassworld", name: "修改个人密码", icon: "fa-key", closable: !0};
            scope.editPassworld = function () {
                editPassworldTab.url = "org/user/userPasswordEdit.html?id=" + scope.userMsg.user.id, scope.menuClick(editPassworldTab)
            };
            var editUserInfoTab = {id: "editUserInfo", name: "个人信息编辑", icon: "fa-info", closable: !0};
            scope.editUserInfo = function () {
                editUserInfoTab.url = "org/user/userEditInformation.html?id=" + scope.userMsg.user.id, scope.menuClick(editUserInfoTab)
            }
        }]);
        top != window && (top.location = "/index.html"), window.addTab = function (tab, fullTab) {
            var scope = angular.element($("[ng-controller='indexCtrl']")).scope();
            scope.$apply(function () {
                scope.menuClick(tab)
            }), fullTab && window.setTimeout(function () {
                $(".navbar-minimalize")[0].click()
            }, 10)
        }
    }
});