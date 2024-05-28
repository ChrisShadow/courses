<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Product;

class HomeController extends Controller
{
    public function index()
    {
        return view('indexP');
    }
    public function add_product(Request $request)
    {
        $data = new Product;
        $data->title = $request->addtitle;
        $data->description = $request->adddescription;

        $image = $request->addimage;
        if ($image) {
            $imagename = time() . '.' . $image->getClientOriginalExtension();
            $destinationPath = public_path('/imagesP');
            $image->move($destinationPath, $imagename);
            $data->image = $imagename;
        }

        $data->save();
        return redirect()->back();
    }
    public function show_product()
    {
        $data = Product::all();
        return view('product', compact('data'));
    }
    public function delete_product($id)
    {
        $data = Product::find($id);
        $data->delete();
        return redirect()->back();
    }
    public function update_product($id)
    {
        $data = Product::find($id);
        return view('editP', compact('data'));
    }
    public function edit_product(Request $request, $id)
    {
        $data = Product::find($id);
        $data->title = $request->uptitle;
        $data->description = $request->updescription;

        $image = $request->upimage;
        if ($image) {
            $imagename = time() . '.' . $image->getClientOriginalExtension();
            $destinationPath = public_path('/imagesP');
            $image->move($destinationPath, $imagename);
            $data->image = $imagename;
        }

        $data->save();
        return redirect()->back();
    }
}
