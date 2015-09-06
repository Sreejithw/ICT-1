<!--=======================================================
                View order modal window
===========================================================-->

<div id="view_order_mw" class="modal_window">

    <button class="close arcticmodal-close"></button>

    <header class="on_the_sides">

        <div class="left_side">

            <h2>Order Details</h2>

        </div>

    </header><!--/ .on_the_sides-->

    <div class="table_wrap">

        <table class="table_type_1 order_review" id="viewOrder">

            <thead>

                <tr>

                    <th class="product_title_col">Product Name</th>
                    <th class="product_sku_col">ID</th>
                    <th class="product_price_col">Price</th>
                    <th class="product_qty_col">Quantity</th>
                    <th class="product_total_col">Total</th>

                </tr>

            </thead>

            <tbody>
                ${row!}
            </tbody>

            <tfoot>

                <tr>

                    <td colspan="4" class="bold">Subtotal</td>
                    <td class="total">${subtotal!}</td>

                </tr>

                <tr>

                    <td colspan="4" class="bold">Shipping &amp; Handling</td>
                    <td class="total">${shipping!}</td>

                </tr>

                <tr>

                    <td colspan="4" class="grandtotal">Grand Total</td>
                    <td class="grandtotal">${total!}</td>

                </tr>

            </tfoot>

        </table>

    </div><!--/ .table_wrap -->

</div>

<!--=======================================================
                End of View order modal window
===========================================================-->