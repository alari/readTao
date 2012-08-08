class UrlMappings {

	static mappings = {
		"/"(controller: "root")
        "/next"(controller: "root", action: "next")
        "/about"(view: "/about")
        "/credits"(view: "/credits")
        "404"(controller: "root", action: "error")
		"500"(view:'/error')
	}
}
