import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLTextAreaElement
import org.w3c.dom.asList
import kotlin.browser.document

fun copyToClipboard(text: String) {
    (document.createElement("textarea") as HTMLTextAreaElement).apply {
        value = text
        document.body!!.append(this)
        select()
        document.execCommand("copy")
        remove()
    }
}

fun main() {
    document.getElementsByClassName("code-frame").asList().forEach {
        val codeFrame = it as HTMLElement
        codeFrame.style.position = "relative"
        (document.createElement("button") as HTMLButtonElement).apply {
            val code = codeFrame.innerText
            innerText = "Copy"
            style.apply {
                right = "0"
                top = "0"
                position = "absolute"
                margin = "4px"
            }
            onclick = {
                copyToClipboard(code)
            }
            codeFrame.appendChild(this)
        }
    }
}
