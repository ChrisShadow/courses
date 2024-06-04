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

        $request->validate([
            'addtitle' => 'required|min:5', //|min:6, email,|unique:products 
            'adddescription' => 'required|max:25',
            'addimage' => 'required|image|mimes:jpeg,png,jpg,gif,svg|max:2048',
        ],
        [
            'addtitle.required' => 'Title is required',
            'addtitle.min' => 'Title must be at least 5 characters',
            'adddescription.required' => 'Description is required',
            'adddescription.max' => 'Description must be at most 25 characters',
            'addimage.required' => 'Image is required',
            'addimage.image' => 'Image must be an image',
            'addimage.mimes' => 'Image must be a file of type: jpeg, png, jpg, gif, svg',
            'addimage.max' => 'Image must be at most 2048 kilobytes',
        ]
    
    );
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
