
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Senpai/Desktop/New folder/conf/routes
// @DATE:Mon May 30 01:46:56 EEST 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
