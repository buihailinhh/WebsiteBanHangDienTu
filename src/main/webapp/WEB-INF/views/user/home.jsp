<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<!-- directive của JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trung tâm TBNH Hải Đăng</title>
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;700&display=swap" rel="stylesheet">
    <!-- Jquery -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- ScrollReveal -->
    <script src="${classpath}/user/js/scrollreveal.min.js"></script>
    <!-- BoxIcon -->
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <!-- Swiper -->
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${classpath}/user/bootstrap/css/bootstrap.min.css">
    <!-- Reset CSS -->
    <link rel="stylesheet" href="${classpath}/user/css/reset.css">
    <!-- Style CSS -->
    <link rel="stylesheet" href="${classpath}/user/css/style.css">
     <!-- Reponsive -->
    <link rel="stylesheet" href="${classpath}/user/css/reponsive.css">

   
</head>

<body>
    <div class="wrapper">
        <header class="header">
            <div class="header__top">
                <div class="container">
                    <p class="header__top-title">
                        Welcome To our shop !
                    </p>
                </div>
            </div>
            <div class="header__bottom">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-4 col-6">
                            <div class="header__bottom-logo">
                                <a href="#"><img src="${classpath}/user/img/logo-3.png" alt="Ảnh logo" class="logo"></a>
                            </div>
                        </div>
                        <div class="col-lg-6 block none">
                            <div class="header__bottom-menu">
                                <ul>
                                    <li class="header__bottom-menu-children"><a href="${classpath}/user/index.html">Trang chủ</a></li>
                                    <li class="header__bottom-menu-children">
                                        <a href="${classpath}/user/danhmuc.html">Thiết Bị</a>
                                        <ul class="mega__subnav">
                                            <li class="mega__subnav-menu">
                                                <h4 class="mega__menu-title">Máy Phát Hiện Tiền Gỉa, Tiền lẫn</h4>
                                                <ul class="mega__subnav-menu-2">
                                                    <li><a href="${classpath}/user/danhmuc.html">Máy đếm tiền Modul 8000</a></li>
                                                    <li><a href="${classpath}/user/danhmuc.html">Quạt cây BQP</a></li>
                                                    <li><a href="${classpath}/user/danhmuc.html">Tivi LG 139</a></li>
                                                    <li><a href="${classpath}/user/danhmuc.html">Tủ lạnh Shap</a></li>
                                                    <li><a href="${classpath}/user/danhmuc.html">Quạt để bàn</li>
                                                    <li><a href="${classpath}/user/danhmuc.html">Điều hòa casper 123</a></li>
                                                </ul>
                                            </li>
                                            <li class="mega__subnav-menu">
                                                <h4 class="mega__menu-title">sản phẩm giảm giá</h4>
                                                <ul class="mega__subnav-menu-2">
                                                    <li><a href="${classpath}/user/danhmuc.html"> Quạt hơi mước</a></li>
                                                    <li><a href="${classpath}/user/danhmuc.html">Tủ lạnh LG</a></li>
                                                    <li><a href="${classpath}/user/danhmuc.html">Ti vi SONY 24 inch</a></li>
                                                    <li><a href="${classpath}/user/danhmuc.html"></a></li>
                                                    <li><a href="${classpath}/user/danhmuc.html"></a></li>
                                                    <li><a href="${classpath}/user/danhmuc.html"></a></li>
                                                </ul>
                                            </li>

                                            
                                        </ul>
                                    </li>
                                    <li class="header__bottom-menu-children"><a href="#">Phụ kiện</a></li>
                                    <li class="header__bottom-menu-children">
                                        <a href="#">Dịch vụ</a>
                                        <ul class="subnav">
                                            <li><a href="#">Lắp đặt</a></li>
                                            <li><a href="#">Bảo dưỡng</a></li>
                                            <li><a href="#">Đổi sản phẩm</a></li>

                                        </ul>
                                    </li>
                                    <li class="header__bottom-menu-children"><a href="${classpath}/user/lienhe.html">Liên hệ</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-8 col-6">
                            <div class="header__bottom-actions">
                                <div class=" header__bottom-btn header__bottom-search">
                                    <a href="#"><i class='bx bx-search'></i></a>
                                    <div class="header__box">
                                        <div class="header__bottom-box-search">
                                            <input type="text" placeholder="Tìm kiếm..." class="header__search-input">
                                            <div class="header__search-btn">
                                                <i class='bx bx-search'></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class=" header__bottom-btn header__bottom-user">
                                    <a href="${classpath}/user/pages/login/login.html"><i class='bx bx-user'></i></a>
                                </div>
                                <div class=" header__bottom-btn header__bottom-cart">
                                    <a href="/cart-view"><i class='bx bx-cart'></i></a>
                                    
                                    <span id="totalCartProductsId" class="header__bottom-num">${ totalCartProducts }</span>
                                    
                                    <div class="header__box-cart">
                                        <div class="header__bottom-box-cart">
                                            <div class="header__cart-products">
                                                <div class="cart-product-inner">
                                                    <div class="cart-product__main">
                                                        <div class="cart-product__thumb">
                                                            <img src="${classpath}/user/img/products/3.jpg" class="cart-product-img">
                                                        </div>
                                                        <div class="cart-product__content">
                                                            <a href="${classpath}/user/sanpham.html">
                                                                <p class="cart-product__content-title">POODLE NÂU ĐỎ
                                                                    ĐÁNG YÊU
                                                                </p>
                                                            </a>
                                                            <p class="cart-product__content-quantity">Số lượng: 1</p>
                                                        </div>
                                                    </div>
                                                    <div class="cart-product__close">
                                                        <i class='bx bx-x'></i>
                                                    </div>
                                                </div>
                                                <div class="cart-product-inner">
                                                    <div class="cart-product__main">
                                                        <div class="cart-product__thumb">
                                                            <img src="${classpath}/user/img/products/1.png" class="cart-product-img">
                                                        </div>
                                                        <div class="cart-product__content">
                                                            <a href="${classpath}/user/sanpham.html">
                                                                <p class="cart-product__content-title">MÈO TAI CỤP CƯNG
                                                                    CƯNG
                                                                </p>
                                                            </a>
                                                            <p class="cart-product__content-quantity">Số lượng: 1</p>
                                                        </div>
                                                    </div>
                                                    <div class="cart-product__close">
                                                        <i class='bx bx-x'></i>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            <div class="header__cart-product-buy">
                                                <a href="#" class="buy-product">Mua hàng</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="header__bottom-btn header__bottom-mobilemenu">
                                    <i class='bx bx-menu'></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="header__slider">
                <div class="swiper mySwiper ">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide .header__slider-imgs">
                            <img src="${classpath}/user/img/slider-1.jpg" alt="" class="header__slider-img">
                        </div>
                        <div class="swiper-slide .header__slider-imgs">
                            <img src="${classpath}/user/img/slider-2.jpg" alt="" class="header__slider-img">
                        </div>
                        <div class="swiper-slide .header__slider-imgs">
                            <img src="${classpath}/user/img/slider-3.jpg" alt="" class="header__slider-img">
                        </div>
                        <div class="swiper-slide .header__slider-imgs">
                            <img src="${classpath}/user/img/slider-4.png" alt="" class="header__slider-img">
                        </div>
                    </div>
                    <div class="swiper-button-next next"></div>
                    <div class="swiper-button-prev prev"></div>
                </div>
            </div>
        </header>
        <main class="main">
            <div class="main__products-hot">
                <div class="container">
                    <div class="main__products-title">
                        <p>Mặt hàng hiện có</p>
                    </div>
                    <div class="main__products-content">
                        <div class="row">
                        
                        <c:forEach var="product" items="${products }">
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">  
                                    <div class="thumb">
                                        <a href="${classpath}/user/sanpham.html" class="image">
                                            <img src="${classpath}/FileUpload/${product.avatar}" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <span class="sale">-20%</span>
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/user/sanpham.html" class="content-link">
                                            <h5 class="title">${product.name}</h5>
                                        </a>
                                        <span class="price">
                                            <!-- <span class="old">8.000.000</span> -->
                                            <span >
                                            <fmt:formatNumber value="${product.price }" minFractionDigits="0"></fmt:formatNumber>
                                             <sup>vnđ</sup>
                                            
                                            </span>
                                           
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#" onclick ="addToCart(${product.id}, 1)"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            
                        
                            </c:forEach>
                        </div>
                    </div>
                    <!-- <div class="main__products-more">
                        <a href="#">Xem thêm</a>
                    </div> -->
                </div>
            </div>
            <!-- Sale -->


            
            <!-- Danh mục sản phẩm -->
            
            <!-- Danh sách phụ kiện -->
           
            <!-- Tin tức -->

            
            <!-- main bottom -->
            
        </main>
        <footer class="footer">
            <div class="footer__top">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-lg-3 col-md-6">
                            <div class="footer-widget">
                                <div class="widget-header">
                                    <h1 class="title">Về chúng tôi</h1>
                                </div>
                                <div class="widget-content">
                                    <p>Với phương châm khách hàng là thượng đế, đề cao sự chính xác. Chúng tôi cam kết bán đúng giá, đúng chất lượng, tư vấn, bán hàng, bảo hành chu đáo đến với khách hàng</p>
                                </div>
                                <div class="widget-social">
                                    <i class='bx bxl-facebook'></i>
                                    <i class='bx bxl-instagram'></i>
                                    <i class='bx bxl-youtube'></i>
                                    <i class='bx bxl-github'></i>
  
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-lg-3 col-md-6">
                            <div class="footer-widget">
                                <div class="widget-header">
                                    <h1 class="title">Hỗ trợ khách hàng</h1>
                                </div>
                                <div class="widget-list">
                                    <ul>
                                        <li><a href="#">Hướng dẫn mua hàng</a></li>
                                        <li><a href="#">Điều khoản và điều kiện</a></li>
                                        <li><a href="#">Chính sách bảo mật</a></li>
                                        <li><a href="#">Chính sách thanh toán</a></li>
                                        <li><a href="#">Chất lượng dịch vụ</a></li>
                                        <li><a href="#">Hướng dẫn gửi trả hàng</a></li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                        <div class="col-12 col-lg-3 col-md-6">
                            <div class="footer-widget">
                                <div class="widget-header">
                                    <h1 class="title">Địa chỉ liên hệ</h1>
                                </div>
                                <div class="widget-list">
                                    <ul>
                                        <li>Mr. Bùi Hải Đăng</li>
                                        <li>Ngõ 2,Đại lộ Thăng Long, Nam Từ Liêm, Hà Nội</li>
                                        <li>Email: <i>mail@gmail.com.vn</i></li>
                                        <li>Facebook: Bùi Hải Đăng</li>
                                        <li>Hotline: 0946512323</li>
                                        <li>buihaidang2904@gmail.com</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-lg-3 col-md-6">
                            <div class="footer-widget">
                                <div class="widget-header">
                                    <h1 class="title">Đăng ký nhận tin:</h1>
                                </div>
                                <div class="widget-content">
                                    <p>Đăng ký nhận tin mới nhất và được giảm giá 10% khi mua hàng đầu tiên của
                                        bạn ..</p>
                                </div>
                                <div class="widget-subscribe">
                                    <form action="">
                                        <input type="email" id="subs-email" placeholder="mail@gmai.com">
                                        <button type="submit" class="widget-btn">Gửi</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <div class="scroll__top">
            <i class='bx bx-up-arrow-alt'></i>
        </div>

        <!-- mobile menu -->
        
    </div>
    <!-- Slider -->
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

    <script src="${classpath}/user/js/app.js"></script>
    <script src="${classpath}/user/js/mobileMenu.js"></script>
    
    <script type="text/javascript">
    	function addToCart (productId, quantity) {
			//javascript object
			let data = {
				
				productId: productId,// lay theo id
				quantity: quantity
			};
			
			//$ === jQuery
			jQuery.ajax({
				url : "/add-to-cart",
				type : "POST",
				contentType: "application/json",
				data : JSON.stringify(data),
				dataType : "json", //Kieu du lieu tra ve tu controller la json
				
				success : function(jsonResult) {
					let totalProducts = jsonResult.totalCartProducts;
					$("#totalCartProductsId").html(totalProducts);
				},
				
				error : function(jqXhr, textStatus, errorMessage) {
					/* alert("An error occur"); */
				}
			});
		}
    </script>
</body>

</html>