<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="breadcrumb-contain container pl-0">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <a:forEach var="item" items="${listPreadcrumb}">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/${item[1]}">${item[0]}</a>
                    </li>
                </a:forEach>
                <script type="text/javascript">
                    var items = document.querySelectorAll('.breadcrumb li a')
                    var itemLast = items[items.length - 1]
                    itemLast.href = '#';
                    itemLast.parentElement.classList.add('active')
                    itemLast.parentElement.ariaCurrent = "page"
                    itemLast.parentElement.innerText = itemLast.innerText
                </script>

            </ol>
        </nav>
    </div>